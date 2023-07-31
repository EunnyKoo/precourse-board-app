<script>
import {defineComponent} from 'vue'
import ConfirmDialog from "@/components/comm/ConfirmDialog.vue";

export default defineComponent({
  name: "PostsNew",
  components: {ConfirmDialog},
  data() {
    return {
      type: '',
      rules: [v => v.length <= 25 || 'Max 25 characters'],
      payload: {
        contents: '',
        title: '',
        author: '',
        password: '',
      },
      dialog: false,
      dialogText: '저장하시겠습니까?',
    };
  },
  created() {
    this.type= this.$route.meta.type
  },
  methods: {
    save() {
      this.dialog = false
      // 저장
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
  <confirm-dialog :open="dialog" :text="dialogText" @check="save" @cancel="cancel"/>
</template>

<style scoped>

</style>