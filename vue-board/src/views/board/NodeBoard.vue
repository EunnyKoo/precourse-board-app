<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "NodeBoard",
  data() {
    return {
      title: 'Node',
    };
  },
})
</script>

<template>
  <v-card :title="title" elevation="5" style="text-align: center" class="ma-3 pa-1" rounded="xl"/>
  <router-view />
</template>
