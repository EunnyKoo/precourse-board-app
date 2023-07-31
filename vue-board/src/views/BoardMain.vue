<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "BoardMain",
  data() {
    return {
      springImg: require(`@/assets/images/springstar.webp`),
      nodeImg: require(`@/assets/images/nodecom.jpeg`),
      reactImg: require(`@/assets/images/react.jpeg`),
    };
  },
})
</script>

<template>
  <v-carousel hide-delimiters style="margin-top: 100px;">
    <v-carousel-item
        :src="springImg"
        cover
        @click="this.$router.push('/spring')"
    ></v-carousel-item>

    <v-carousel-item
        :src="nodeImg"
        cover
        @click="this.$router.push('/node')"
    ></v-carousel-item>

    <v-carousel-item
        :src="reactImg"
        cover
        @click="this.$router.push('/react')"
    ></v-carousel-item>
  </v-carousel>
</template>

<style scoped>

</style>