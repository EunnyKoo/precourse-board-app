<script>
import NavBar from "@/components/NavBar.vue";

export default {
  name: 'App',
  components: {NavBar},
  data() {
    return {
      drawer: false,
      title: '프리코스 게시판',
      footImg: require(`@/assets/images/tan.png`),
    }
  },
  methods: {
    close() {
      this.drawer = false;
    }
  }
}
</script>

<template>
<div id="app">
  <v-app id="inspire">
    <v-app-bar>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>{{title}}</v-toolbar-title>
    </v-app-bar>

    <NavBar v-model="drawer" @close="close"/>

    <v-main class="bg-grey-lighten-2">
      <v-container fluid >
       <router-view />
      </v-container>
    </v-main>

    <v-footer>
      <v-row justify="center" no-gutters>
        <v-img
            class="mx-auto"
            height="80"
            max-width="100"
            :src="footImg"
        />
      </v-row>
    </v-footer>
  </v-app>
</div>
</template>