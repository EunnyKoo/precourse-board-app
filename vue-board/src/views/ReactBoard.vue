<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "ReactBoard",
  data() {
    return {
      title: 'React',
    };
  },
})
</script>

<template>
  <v-card :title="title" elevation="5" style="text-align: center" class="ma-2"/>
  <router-view/>
</template>
