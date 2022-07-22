export default {
    props: ['items'],
    data () {
        return {
            loading: true
        }
    },
    mounted() {
        this.loading = false;
    },
}