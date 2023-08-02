<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "SnackBar",
  props: {
    open: {
      type: Boolean,
      default: false,
    },
    text: {
      type: String,
      default: '',
    }
  },
  data() {
    return {
      timeout: 1000,
      snackBar: false,
    }
  },
  watch: {
    open() {
      this.snackBar = true
    },
    snackBar(val) {
      if(val === false) {
        this.$emit('move')
      }
    }
  }
})
</script>

<template>
  <div class="text-center">
    <v-snackbar
        v-model="snackBar"
        :timeout="timeout"
    >
      {{ text }}

      <template v-slot:actions>
        <v-btn
            color="blue"
            variant="text"
            @click="snackBar = false"
        >
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </div>
</template>

<style scoped>

</style>