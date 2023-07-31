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
  <v-card :title="title" elevation="5" style="text-align: center" class="ma-2" />
  <router-view />
</template>
