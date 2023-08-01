<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "ConfirmDialog",
  data () {
    return {
      dialog: false,
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
        width="auto"
    >
      <v-card width="700" elevation="3">
        <v-card-title class="text-h5">
          확인
        </v-card-title>
        <v-card-text>
          {{text}}
        </v-card-text>
        <v-card-actions>
          <v-spacer/>
          <v-btn
              color="green"
              variant="text"
              elevation="3"
              @click="$emit('check')"
          >
            확인
          </v-btn>
          <v-btn
              color="red"
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
