<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "NavBar",
  data() {
    return {
      items: [
        {
          title: '게시판',
          value: '/',
          props: {
            prependIcon: 'mdi-bulletin-board',
            rounded: 'pill',
            elevation: 3
          }
        },
        {
          title: '글작성',
          value: '/posts/new',
          props: {
            prependIcon: 'mdi-pencil',
            rounded: 'pill',
            elevation: 3
          }
        },
      ],
    };
  },
  methods: {
    navClick(val) {
      this.$router.push(val.id);
      this.$emit('close')
    }
  }
})
</script>

<template>
  <v-navigation-drawer
      location="bottom"
      temporary
  >
    <v-list
        :items="items"
        @click:select="navClick"
    />
  </v-navigation-drawer>
</template>

<style scoped>

</style>