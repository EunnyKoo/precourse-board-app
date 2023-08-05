<script>
import {defineComponent} from 'vue'
import boardService from "@/service/boardService";

export default defineComponent({
  name: "SignupForm",
  data () {
    return {
      data: {
        author: '',
        password: '',
        email: '',
        phone: ''
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
    async signup() {
     await boardService.signup(this.data)
          .then(({data}) => {
            if(data === 'success')
              this.$router.push('/login')
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
      <span class="text-h5">Signup</span>
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
        <v-row>
          <v-col sm="6">
            <v-text-field
                label="Email"
                v-model="data.email"
            ></v-text-field>
          </v-col>

          <v-col sm="6">
            <v-text-field
                label="Phone"
                v-model="data.phone"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-card-text>
    <v-card-actions>
      <v-spacer/>
      <v-btn
          color="green"
          variant="text"
          elevation="3"
          @click="signup"
      >
        회원가입
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