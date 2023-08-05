<script>
import {defineComponent} from 'vue'
import ConfirmDialog from "@/components/comm/ConfirmDialog.vue";
import AuthorCheck from "@/components/comm/AuthorCheck.vue";
import SnackBar from "@/components/comm/SnackBar.vue";
import boardService from "@/service/boardService";
import Cookies from "js-cookie";

export default defineComponent({
  name: "PostsUpdate",
  components: {SnackBar, AuthorCheck, ConfirmDialog},
  data() {
    return {
      id : '',
      type: '',
      rules: [v => v.length <= 1500 || '최대 1500자까지 가능합니다.'],
      payload: {
        contents: '',
        title: '',
        author: '',
        password: '',
      },
      dialog: false,
      check: false,
      dialogText: '수정하시겠습니까?',
      snackBarText: '',
      snackBar: false,
    };
  },
  created() {
    const token = Cookies.get('accessToken');
    if(token === null || token === undefined) this.$router.push('/')

    this.type = this.$route.meta.type;
    this.id= this.$route.params.id;

    this.getPost();
  },
  methods: {
    async getPost() {
      await boardService.getPost(this.id, this.type)
          .then(({data}) => {
            this.payload = data;
          })
          .catch(err => {
            alert(err)
          })
    },
    async updatePost() {
      this.dialog = false
      this.check = false

      if (this.payload.contents.length > 1500) {
        this.snackBarText = '내용은 최대 1500자까지 가능합니다.'
        this.snackBar = !this.snackBar;
        return
      }

      await boardService.updatePost(this.id, JSON.stringify(this.payload), this.type)
          .then(({data}) => {
            if(data === 'success') {
              this.snackBarText = '수정을 성공하셨습니다.'
              this.snackBar = !this.snackBar;
            } else {
              this.snackBarText = '수정을 실패하셨습니다.'
              this.snackBar = !this.snackBar;
            }
          })
          .catch(err => {
            alert(err)
          })
    },
    move() {
      this.$router.push({ name: `${this.type}Detail`, params: {id: this.id}})
    },
    cancel() {
      this.dialog = false
    },
    authorCheck(data) {
      this.payload.author = data?.author;
      this.payload.password = data?.password;
      this.dialog = true
    },
    authorCancel() {
      this.check = false
    }
  }
})
</script>

<template>
  <v-col align-self="center">
    <v-card class="pa-5" width="auto" height="auto" rounded="xl" elevation="5">
      <v-card-item>
        <v-text-field label="Title" v-model="payload.title" variant="solo-filled"></v-text-field>
      </v-card-item>
      <v-container fluid>
        <v-textarea
            counter
            label="Contents"
            :rules="rules"
            v-model="payload.contents"
        ></v-textarea>
      </v-container>

      <v-card-actions style="float: right">
        <v-btn elevation="5"
               @click="dialog = true"
               prepend-icon="mdi-check-circle"
        >
          <template v-slot:prepend>
            <v-icon color="success"></v-icon>
          </template>
          수정
        </v-btn>
        <v-btn elevation="5"
               @click="this.$router.push({ name: `${this.type}Detail`, params: {id}})"
               prepend-icon="mdi-check-circle"
        >
          <template v-slot:prepend>
            <v-icon color="warning"></v-icon>
          </template>
          취소
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-col>
  <confirm-dialog :open="dialog" :text="dialogText" @check="updatePost" @cancel="cancel"/>
<!--  <author-check :open="check" @check="authorCheck" @cancel="authorCancel" />-->
  <snack-bar :text="snackBarText" :open="snackBar"  @move="move"/>
</template>
