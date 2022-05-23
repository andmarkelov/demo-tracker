
var pointRepo = Vue.resource("/api/geo{/id}");

Vue.component("geopos-edit-form", {
    props: {geo_points:{}, enabled:{default:true}},
    data: function () {
        return {
            lat: '',
            lon: ''
        }
    },
    template:
        '<div :class="enabled?&quot;&quot;:&quot;elem-disabled&quot;">\n' +
        '    <input  name="lat" v-model="lat" type="text" size="20" autocomplete="off" placeholder="latitude"/>\n' +
        '    <input name="lon" v-model="lon" type="text" size="20" autocomplete="off" placeholder="longitude"/>\n' +
        '    <button @click="addGeoPoint">add</button>\n' +
        '</div>',
    methods: {
        addGeoPoint: function () {
            var pointData = {lat: this.lat, lon: this.lon, created: new Date()};
            this.enabled = false;
            pointRepo.save({}, pointData).then(
                result => {
                        result.json().then(data => {

                            this.geo_points.push(data);
                            this.lat = '';
                            this.lon = '';
                            this.enabled = true;
                        })
                }

            );
        }
    }
});

Vue.component("geopos-item", {
    props: ['data'],
    template:
        '<div class="geodiv">' +
        '<tr>' +
        '<td><b>{{data.lat}}</b></td>' +
        '<td><b>{{data.lon}}</b></td>' +
        '<td><button @click="deletePoint">Delete</button></td>' +
        '</tr>' +
        '</div>',
    methods: {
        deletePoint: function () {
            pointRepo.delete({id: this.data.id}).then(result => {
                this.$destroy();
                this.$el.parentNode.removeChild(this.$el);
            });
        }
    }
});

Vue.component("geopos-list", {
    props: ['items'],
    template:
        '<table class="geotable">' +
        '<geopos-item v-for="item in items" :key="item.id" :data="item"/>' +
        '</table>',
    created: function() {
        pointRepo.get().then(
            result => result.json().then(
                 data => data.forEach(
                     point => this.items.push(point)
                 )
            )
        )
    }
});



var app = new Vue({
    el: '#app',
    template: '<div><geopos-edit-form :geo_points = "geo_points"/><geopos-list :items = "geo_points"/></div>',
    data: {
        geo_points: []
    }  

});


