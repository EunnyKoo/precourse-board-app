<script>
import {defineComponent} from 'vue'
import boardService from "@/service/boardService";

export default defineComponent({
  name: "BoardTable",
  data () {
    return {
      search: '',
      type: '',
      page: 1,
      itemsPerPage: 10,
      headers: [
        {
          title: 'No',
          align: 'center',
          key: 'id',
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
      desserts: [],
    }
  },
  computed: {
    pageCount () {
      return Math.ceil(this.desserts.length / this.itemsPerPage)
    },
  },
  async created() {
    this.type = this.$route.meta.type;

    await boardService.getBoard(this.type)
        .then(({data}) => {
          this.desserts = data;
        })
        .catch(err => {
          alert(err)
        })
  },
  methods: {
    clickRow(event, {item}) {
      const row = item.columns;
      const id = row.id;
      console.log(id)
      this.$router.push({ name: `${this.type}Detail`, params: {id}})
    }
  }
})
</script>

<template>
<!--  <v-card-title>-->
<!--    <v-text-field-->
<!--        v-model="search"-->
<!--        append-icon="mdi-magnify"-->
<!--        label="Search"-->
<!--        single-line-->
<!--        hide-details-->
<!--    ></v-text-field>-->
<!--  </v-card-title>-->
  <v-data-table
      v-model:page="page"
      :headers="headers"
      :items="desserts"
      :items-per-page="itemsPerPage"
      hide-default-footer
      class="elevation-1"
      @click:row="clickRow"
      :search="search"
  >
    <template v-slot:bottom>
      <div class="text-center pt-2">
        <v-pagination
            v-model="page"
            :length="pageCount"
        ></v-pagination>
<!--        <v-text-field-->
<!--            :model-value="itemsPerPage"-->
<!--            class="pa-2"-->
<!--            label="Items per page"-->
<!--            type="number"-->
<!--            min="-1"-->
<!--            max="15"-->
<!--            hide-details-->
<!--            @update:model-value="itemsPerPage = parseInt($event, 10)"-->
<!--        ></v-text-field>-->
      </div>
    </template>
  </v-data-table>
</template>

<style scoped>

</style>