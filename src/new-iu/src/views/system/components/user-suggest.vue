<template>
  <el-autocomplete
    :value="value"
    :size="size"
    :style="styleObject"
    :debounce="debounce"
    :clearable="clearable"
    :placeholder="placeholder"
    :fetch-suggestions="queryCIProject"
    popper-class="user-suggest-popper"
    @input="onInput"
    @select="confirmSelect"
  >
    <template slot-scope="{ item }">
      <div class="smark">{{ item.userId }}</div>
      <div class="sname">{{ item.username }}</div>
    </template>
  </el-autocomplete>
</template>

<style lang="scss">
    .user-suggest-popper{
        .el-autocomplete-suggestion__wrap{
            max-height: 500px;
        }
    }
</style>

<style lang="scss" scoped>
    .smark{
        font-size: 14px;
        margin-top: 6px;
        line-height: 20px;
    }
    .sname{
        font-size: 10px;
        color: #9a9a9b;
        margin-bottom: 6px;
        line-height: initial;
    }
</style>

<script>
    import { userSuggest } from '@/api/system/common'

    export default {
        model: {
            prop: 'value',
            event: 'input'
        },
        props: {
            value: {
                type: String,
                default: ''
            },
            size: {
                type: String,
                default: ''
            },
            debounce:{
                type: Number,
                default: 300
            },
            clearable: {
                type: Boolean,
                default: false
            },
            placeholder: {
                type: String,
                default: ''
            },
            styleObject: {
                type: Object,
                default: () => {
                    return {
                        width: '100%'
                    }
                }
            }
        },
        data() {
            return {
                lastQueryString: undefined,
                lastQueryResult: []
            }
        },
        methods: {
            onInput(value){
                this.$emit('input', value)  
            },
            confirmSelect(item){
                this.$emit('input', item.userId)
                this.$emit('select', item)
            },
            queryCIProject(queryString, cb){
                if(this.lastQueryString !== queryString){
                    userSuggest({ value: queryString }).then(res => {
                        this.lastQueryString = queryString
                        this.lastQueryResult = res
                        cb(res)
                    })
                }else{
                    cb(this.lastQueryResult)
                }
            }
        }
    }
</script>