<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "NavBar",
  data() {
    return {
      auth: false,
      openSpring: ['Spring'],
      openNode: ['Node'],
      openReact: ['React'],
    };
  },
  methods: {
    logout() {
      alert("LOGOUT")
    }
  }
})
</script>

<template>
  <v-navigation-drawer
      location="bottom"
      temporary
  >
    <v-list v-model:opened="openSpring" color="#D2691E">
      <v-list-group value="Spring">
        <template v-slot:activator="{ props }">
          <v-list-item
              v-bind="props"
              prepend-icon="mdi-folder"
              title="Spring"
              rounded="xl"
              elevation="3"
          />
        </template>
        <v-list-item
            title="게시판"
            rounded="xl"
            elevation="1"
            link
            to="/"
        >
          <template v-slot:prepend>
            <v-icon>mdi-bulletin-board</v-icon>
          </template>
        </v-list-item>
        <v-list-item
            title="작성"
            rounded="xl"
            elevation="1"
            link
            to="/spring/posts/new"
        >
          <template v-slot:prepend>
            <v-icon>mdi-pencil</v-icon>
          </template>
        </v-list-item>
      </v-list-group>
    </v-list>
    <v-list v-model:opened="openNode" color="#D2691E">
      <v-list-group value="Node">
        <template v-slot:activator="{ props }">
          <v-list-item
              v-bind="props"
              prepend-icon="mdi-folder"
              title="Node"
              rounded="xl"
              elevation="2"
          ></v-list-item>
        </template>
        <v-list-item
            title="게시판"
            rounded="xl"
            elevation="1"
            link
            to="/node"
        >
          <template v-slot:prepend>
            <v-icon>mdi-bulletin-board</v-icon>
          </template>
        </v-list-item>
        <v-list-item
            title="작성"
            rounded="xl"
            elevation="1"
            link
            to="/node/posts/new"
        >
          <template v-slot:prepend>
            <v-icon>mdi-pencil</v-icon>
          </template>
        </v-list-item>
      </v-list-group>
    </v-list>
    <v-list v-model:opened="openReact" color="#D2691E">
      <v-list-group value="Node">
        <template v-slot:activator="{ props }">
          <v-list-item
              v-bind="props"
              prepend-icon="mdi-folder"
              title="React"
              rounded="xl"
              elevation="2"
          ></v-list-item>
        </template>
        <v-list-item
            title="게시판"
            rounded="xl"
            elevation="1"
            link
            to="/react"
        >
          <template v-slot:prepend>
            <v-icon>mdi-bulletin-board</v-icon>
          </template>
        </v-list-item>
        <v-list-item
            title="작성"
            rounded="xl"
            elevation="1"
            link
            to="/react/posts/new"
        >
          <template v-slot:prepend>
            <v-icon>mdi-pencil</v-icon>
          </template>
        </v-list-item>
      </v-list-group>
    </v-list>

    <template v-slot:append>
      <div class="pa-2" v-show="!auth">
        <v-btn
            block rounded="xl"
            elevation="5"
            color="brown"
            @click="auth=!auth; this.$router.push('/login')"
        >
          LOGIN
        </v-btn>
      </div>
      <div class="pa-2" v-show="auth">
        <v-btn
            block rounded="xl"
            elevation="5"
            color="brown"
            @click="auth=!auth; logout"
        >
          LOGOUT
        </v-btn>
      </div>
    </template>

  </v-navigation-drawer>
</template>

<style scoped>

</style>