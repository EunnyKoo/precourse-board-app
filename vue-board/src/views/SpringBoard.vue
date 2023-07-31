<script>
import {defineComponent} from 'vue'
import BoardTable from "@/components/BoardTable.vue";

export default defineComponent({
  name: "SpringBoard",
  components: {BoardTable},
  data() {
    return {
      title: 'Spring',
    };
  },
  created() {
    const type = this.$route.meta.type;
    console.log(type)
  }
})
</script>

<template>
  <v-card :title="title" style="text-align: center" class="ma-2"/>
  <BoardTable/>
</template>
