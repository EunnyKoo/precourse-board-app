<script>
import {defineComponent} from 'vue'
import BoardTable from "@/components/BoardTable.vue";

export default defineComponent({
  name: "BoardMain",
  components: {BoardTable}
})
</script>

<template>
  <v-bottom-navigation grow >
    <v-btn value="recent">
      <v-icon>mdi-folder</v-icon>
      Spring
    </v-btn>

    <v-btn value="favorites">
      <v-icon>mdi-folder</v-icon>
      Node
    </v-btn>

    <v-btn value="nearby">
      <v-icon>mdi-folder</v-icon>
      React
    </v-btn>
  </v-bottom-navigation>

  <BoardTable/>
</template>

<style scoped>

</style>