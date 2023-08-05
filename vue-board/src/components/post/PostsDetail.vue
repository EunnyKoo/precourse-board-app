<script>
import {defineComponent} from 'vue'
import ConfirmDialog from "@/components/comm/ConfirmDialog.vue";
import boardService from "@/service/boardService";
import SnackBar from "@/components/comm/SnackBar.vue";
import Cookies from "js-cookie";

export default defineComponent({
  name: "PostsDetail",
  components: {SnackBar, ConfirmDialog},
  data() {
    return {
      id: '',
      type: '',
      dialog: false,
      dialogText: '',
      post: {
        title: '',
        contents: '',
        author: ''
      },
      snackBarText: '',
      snackBar: false,
      isAuthor: false,
    };
  },
  created() {
    this.type = this.$route.meta.type;
    this.id = this.$route.params.id;

    this.getPost();
  },
  methods: {
    async getPost() {
      await boardService.getPost(this.id, this.type)
          .then(({data}) => {
            this.post = data;
            const user = this.$store.getters['userStore/getUserInfo']

            if (this.post.author === user.author) this.isAuthor = true;
          })
          .catch(err => {
            alert(err)
          })
    },
    async delPost() {
      this.dialog = false

      await boardService.deletePost(this.id, this.type)
          .then(({data}) => {
            if (data === 'success') {
              this.snackBarText = '삭제를 성공하셨습니다.'
              this.snackBar = !this.snackBar;
            }
          })
          .catch(err => {
            alert(err)
          })
    },
    move() {
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
        <v-card-title>{{ post.title }}</v-card-title>
        <v-card-subtitle style="float: right">{{ post.author }}</v-card-subtitle>
      </v-card-item>
      <v-card-text>
        {{ post.contents }}
      </v-card-text>

      <v-card-actions style="float: right">
        <v-btn v-if="isAuthor"
               elevation="5"
               @click="this.$router.push({name: `${this.type}Update`, params: {id}})"
               prepend-icon="mdi-check-circle"
        >
          <template v-slot:prepend>
            <v-icon color="warning"></v-icon>
          </template>
          수정
        </v-btn>
        <v-btn v-if="isAuthor"
               elevation="5"
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
  <snack-bar :text="snackBarText" :open="snackBar" @move="move"/>
</template>

<style scoped>

</style>