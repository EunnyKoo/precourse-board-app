<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "BoardTable",
  data () {
    return {
      page: 1,
      itemsPerPage: 10,
      headers: [
        {
          title: 'No',
          align: 'center',
          key: 'idx',
          sortable: false,
        },
        {
          title: 'Title',
          align: 'center',
          key: 'title',
          sortable: false,
        },
        { title: 'Author',
          align: 'center',
          key: 'author',
          sortable: false,
        },
        { title: 'Date',
          align: 'center',
          key: 'date',
          sortable: false,
        },

      ],
      desserts: [
        {
          idx: 1,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 2,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 3,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 4,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 5,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 6,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 7,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 8,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 9,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 10,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
        {
          idx: 11,
          title: 'title1',
          author: 'Robbie',
          date: '2023-01-01',
        },
      ],
    }
  },
  computed: {
    pageCount () {
      return Math.ceil(this.desserts.length / this.itemsPerPage)
    },
  },
  methods: {
    clickRow(event, {item}) {
      const row = item.columns;
      const id = row.idx;
      console.log(id)
      this.$router.push({ name: 'detail', params: {id}})
    }
  }
})
</script>

<template>
  <v-data-table
      v-model:page="page"
      :headers="headers"
      :items="desserts"
      :items-per-page="itemsPerPage"
      hide-default-footer
      class="elevation-1"
      @click:row="clickRow"
  >
    <template v-slot:bottom>
      <div class="text-center pt-2">
        <v-pagination
            v-model="page"
            :length="pageCount"
        ></v-pagination>
        <v-text-field
            :model-value="itemsPerPage"
            class="pa-2"
            label="Items per page"
            type="number"
            min="-1"
            max="15"
            hide-details
            @update:model-value="itemsPerPage = parseInt($event, 10)"
        ></v-text-field>
      </div>
    </template>
  </v-data-table>
</template>

<style scoped>

</style>