<template>
  <el-card v-loading="cardLoading" :element-loading-text="cardLoadingText" class="body-card">
    <el-card class="box-card">
      <div slot="header">
        <span>长龙榜</span>
      </div>
      <div v-for="o in 5" :key="o" class="text item">
        {{ '列表内容 ' + o }}
      </div>
      
    </el-card>
  </el-card>
</template>

<style lang="scss" scoped>
    .text {
    font-size: 14px;
    }
    .item {
        margin-bottom: 18px;
    }
    .box-card {
        width: 300px;
    }
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
