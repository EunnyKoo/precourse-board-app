<script>
import {defineComponent} from 'vue'
import ConfirmDialog from "@/components/comm/ConfirmDialog.vue";

export default defineComponent({
  name: "PostsDetail",
  components: {ConfirmDialog},
  data() {
    return {
      id: '',
      type: '',
      dialog: false,
      dialogText: '',
    };
  },
  created() {
    const type = this.$route.meta.type;
    const id = this.$route.params.id;
    this.type = type;
    this.id = id;
  },
  methods: {
    delPost() {
      this.dialog = false
      // 삭제
      this.$router.push({name: `${this.type}Board`})
    },
    cancel() {
      this.dialog = false
    }
  }
})
</script>

<template>
  <v-col align-self="center">
    <v-card class="pa-5" width="auto" height="auto" rounded="xl" elevation="5">
      <v-card-item>
        <v-card-title>This is Title</v-card-title>
        <v-card-subtitle style="float: right">Robbie</v-card-subtitle>
      </v-card-item>
      <v-card-text>
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
        This is Contents This is Contents This is Contents This is Contents This is Contents This is Contents
      </v-card-text>

      <v-card-actions style="float: right">
        <v-btn elevation="5"
               @click="this.$router.push({name: `${this.type}Update`, params: {id}})"
               prepend-icon="mdi-check-circle"
        >
          <template v-slot:prepend>
            <v-icon color="warning"></v-icon>
          </template>
          수정
        </v-btn>
        <v-btn elevation="5"
               @click="dialog = true; dialogText='삭제하시겠습니까?'"
               prepend-icon="mdi-check-circle"
        >
          <template v-slot:prepend>
            <v-icon color="red"></v-icon>
          </template>
          삭제
        </v-btn>
        <v-btn elevation="5"
               @click="this.$router.push({name: `${this.type}Board`})"
               prepend-icon="mdi-check-circle"
        >
          목록
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-col>
  <confirm-dialog :open="dialog" :text="dialogText" @check="delPost" @cancel="cancel"/>
</template>

<style scoped>

</style>