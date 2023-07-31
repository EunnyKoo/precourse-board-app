<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "NavBar",
  data() {
    return {
      openSpring: ['Spring'],
      openNode: ['Node'],
      openReact: ['React'],
      admins: [
        ['Management', 'mdi-account-multiple-outline'],
        ['Settings', 'mdi-cog-outline'],
      ],
      icons: [
        ['Create', 'mdi-plus-outline'],
        ['Read', 'mdi-file-outline'],
        ['Update', 'mdi-update'],
        ['Delete', 'mdi-delete'],
      ],
    };
  },
  methods: {}
})
</script>

<template>
  <v-navigation-drawer
      location="bottom"
      temporary
  >
    <v-list v-model:opened="openSpring">
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
    <v-list v-model:opened="openNode">
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
    <v-list v-model:opened="openReact">
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
  </v-navigation-drawer>
</template>

<style scoped>

</style>