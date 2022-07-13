<template>
  <div id="editable-text-area-root" contenteditable @blur="onEdit" @keydown.enter="endEdit" >{{text}}</div>
</template>

<script>
export default {
  props: ['text'],
  methods:{
    onEdit(evt){
      // var src = evt.target.innerHTML;
      // this.txt = src;
    },
    endEdit(){
      this.$el.querySelector('#editable-text-area-root').blur();
    }
  }
}
</script>

<style scoped>
  #editable-text-area-root {
    min-width: 150px
  }
</style>