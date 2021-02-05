<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    gambling index
  </el-card>
</template>

<style lang="scss" scoped>

</style>

<script>
    export default {
        components: {
        },
        data() {
            return {
                cardLoading: false,
                cardLoadingText: ''
            }
        },
        methods: {
            
        }
    }
</script>
