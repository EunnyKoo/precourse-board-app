<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "AuthorCheck",
  data () {
    return {
      dialog: false,
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
  watch: {
    open(val) {
      this.dialog = val;
    }
  }
})
</script>

<template>
  <v-row justify="center">
    <v-dialog
        v-model="dialog"
        persistent
        width="700"
    >
      <v-card elevation="3">
        <v-card-title>
          <span class="text-h5">Author Check</span>
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
          <v-spacer></v-spacer>
          <v-btn
              color="green-darken-1"
              variant="text"
              elevation="3"
              @click="$emit('check', data)"
          >
            확인
          </v-btn>
          <v-btn
              color="green-darken-1"
              variant="text"
              elevation="3"
              @click="$emit('cancel')"
          >
            취소
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<style scoped>

</style>