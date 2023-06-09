var simulator = {
    initialisedState: false,
    init: function () {
        this.state = new App.Models.State();
        this.views = _.extend({}, Backbone.Events);

        this.views.map = new App.Views.Map({
            el: $("#map_canvas"),
            mapOptions: {
                center: _.position(18.538446, -72.345299),
                zoomControl: true,
                zoom: 19
            },
            state: this.state,
            views: this.views
        });

        this.views.submap = new App.Views.SubMap({
            el: $("#map_canvas_s"),
            mapOptions: {
                center: _.position(0.0, 0.0)
            },
            state: this.state,
            views: this.views
        });

        this.views.camera = new App.Views.Camera({
            el: $("#camera"),
            mapOptions: {
                center: _.position(50.937175, -1.40507)
            },
            state: this.state,
            views: this.views
        });

        this.views.editgraph = new App.Views.Graph({
            el: $("#accordion_agent_schedule_m"),
            state: this.state,
            views: this.views,
            ctx: $("#schedule").get(0).getContext("2d"),
            canvas: $("#schedule").get(0),
            forEditMode: false
        });

        this.views.graph = new App.Views.Graph({
            el: $("#accordion_agent_schedule_e"),
            state: this.state,
            views: this.views,
            ctx: $("#edit_schedule").get(0).getContext("2d"),
            canvas: $("#edit_schedule").get(0),
            forEditMode: true
        });

        // setup accordion for jquery ui
        $("#accordion_smallview").accordion({
            collapsible: true
        });
        $("#accordion_agent_schedule_m").accordion({
            collapsible: true,
            //active: false
        });
        $("#accordion_sotp_m").accordion({
            collapsible: true
        });
        $("#accordion_otherlayer_m").accordion({
            collapsible: true,
            active: false
        });
        $("#accordion_agent_schedule_e").accordion({
            collapsible: true,
        });
        $("#accordion_sotp_e").accordion({
            collapsible: true,
        });

        $("#camera_canvas_s").append($("#camera"));

        this.views.control = new App.Views.Control({
            el: $("#control"),
            state: this.state,
            views: this.views
        });
        this.views.layout = new App.Views.Layout({
            el: $("body"),
            state: this.state,
            views: this.views
        });

        //Configure pop up defaults
        spop.defaults = {
            position  : 'bottom-left',
            autoclose: 5000
        };

        this.run();
    },
    run: function () {
        var waitTime = 400;
        var self = this;
        var startTime = (new Date()).getTime();
        this.state.fetch()
            .done(function () {
                if (!self.initialisedState) {
                    self.initialisedState = true;
                    MapController.swapMode(self.state.isEdit(), false);

                    if (self.state.attributes.prov_doc == null) {
                        var api = new $.provStoreApi({
                            username: 'atomicorchid',
                            key: '2ce8131697d4edfcb22e701e78d72f512a94d310'
                        });
                        var ps = new PostService();
                        ps.initProv(api, 'uav_silver_commander', self.state.getGameId());
                    }

                    if(self.state.getGameType() === self.state.GAME_TYPE_SCENARIO && !self.state.isInProgress()) {
                        var description_panel = document.createElement("div");
                        description_panel.innerHTML = _.template($("#description_panel").html(), {
                            title: self.state.getGameId(),
                            description: self.state.getGameDescription()
                        });
                        $.blockWithContent(description_panel);
                        $('#start_scenario').on('click', function () {
                            $.post("/mode/scenario/start", {}, function () {
                                $.unblockUI();
                            });
                        });
                    }
                }
            })
            .always(function () {
                var elapsedTime = ((new Date()).getTime() - startTime);
                if (elapsedTime < waitTime)
                    window.setTimeout(_.bind(self.run, self), waitTime - elapsedTime);
                else
                    _.bind(self.run, self)();
            });
        $('#view_mode').buttonset().css({
            "margin-right": "0px"
        }).find("label").width("50%");
    }
};