<script>
import {defineComponent} from 'vue'
import ConfirmDialog from "@/components/comm/ConfirmDialog.vue";
import SnackBar from "@/components/comm/SnackBar.vue";
import snackBar from "@/components/comm/SnackBar.vue";
import boardService from "@/service/boardService";

export default defineComponent({
  name: "PostsNew",
  computed: {
    snackBar() {
      return snackBar
    }
  },
  components: {SnackBar, ConfirmDialog},
  data() {
    return {
      type: '',
      rules: [v => v.length <= 1500 || '최대 1500자까지 가능합니다.'],
      payload: {
        contents: '',
        title: '',
        author: '',
        password: '',
      },
      dialog: false,
      dialogText: '저장하시겠습니까?',
      snackBarText: '',
      snackBar: false,
    };
  },
  created() {
    this.type = this.$route.meta.type
  },
  methods: {
    async savePost() {
      this.dialog = false

      if (this.payload.contents.length > 1500) {
        this.snackBarText = '내용은 최대 1500자까지 가능합니다.'
        this.snackBar = !this.snackBar;
        return
      }

      await boardService.savePost(JSON.stringify(this.payload), this.type)
          .then(({data}) => {
            if (data === 'success') {
              this.snackBarText = '등록을 성공하셨습니다.'
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
        <v-text-field label="Title" v-model="payload.title" variant="solo-filled"></v-text-field>
      </v-card-item>
      <v-card-item>
        <v-row>
          <v-col sm="6">
            <v-text-field
                label="Author"
                v-model="payload.author"
            ></v-text-field>
          </v-col>

          <v-col sm="6">
            <v-text-field
                label="password"
                v-model="payload.password"
            ></v-text-field>
          </v-col>
        </v-row>
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
          저장
        </v-btn>
        <v-btn elevation="5"
               @click="this.$router.push({name: `${this.type}Board`})"
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
  <confirm-dialog :open="dialog" :text="dialogText" @check="savePost" @cancel="cancel"/>
  <snack-bar :text="snackBarText" :open="snackBar" @move="move"/>
</template>

<style scoped>

</style>