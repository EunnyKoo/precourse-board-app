<script>
import {defineComponent} from 'vue'
import boardService from "@/service/boardService";
import Cookies from "js-cookie";
import {da, he} from "vuetify/locale";

export default defineComponent({
  name: "LoginForm",
  data() {
    return {
      data: {
        author: '',
        password: '',
      }
    }
  },
  props: {
    open: {
      type: Boolean,
      default: false,
    },
    text: {
      type: String,
      default: ''
    }
  },
  methods: {
    async login() {
      await boardService.login(this.data)
          .then(({headers, data}) => {
            const accessToken = headers['authorization'];
            Cookies.set('accessToken', accessToken, { path: '/app/'});

            this.$store.commit('userStore/setUserInfo', data)
            this.$router.push('/')
          })
          .catch(err => {
            alert(err)
            this.$router.push('/')
          })
    }
  }
})
</script>

<template>
  <v-card elevation="5">
    <v-card-title>
      <span class="text-h5">Author Login</span>
    </v-card-title>
    <v-card-text>
      <v-container>
        <v-row>
          <v-col sm="6">
            <v-text-field
                label="Author"
                v-model="data.author"
            ></v-text-field>
          </v-col>

          <v-col sm="6">
            <v-text-field
                label="password"
                v-model="data.password"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-card-text>
    <v-card-actions>
      <v-btn
          variant="text"
          elevation="3"
          @click="this.$router.push('/signup')"
      >
        회원가입
      </v-btn>
      <v-spacer/>
      <v-btn
          color="green"
          variant="text"
          elevation="3"
          @click="login"
      >
        로그인
      </v-btn>
      <v-btn
          color="red"
          variant="text"
          elevation="3"
          @click="this.$router.push('/')"
      >
        취소
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<style scoped>

</style>