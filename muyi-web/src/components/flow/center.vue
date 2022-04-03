<template>
  <div>
    <el-table :data="tableData" style="width: 100%" border>
      <el-table-column prop="fundCode" header-align="center" align="center" width="100" label="基金代码"></el-table-column>
      <el-table-column prop="fundName" header-align="center" width="300" label="基金名称"></el-table-column>
      <el-table-column prop="etfType" header-align="center" align="center" width="120" label="ETF类型"></el-table-column>
      <el-table-column prop="businessDate" header-align="center" align="center" width="120" label="业务日期"></el-table-column>
      <el-table-column prop="flow" label="流程">
        <template>
          <div class="table-steps">
            <el-popover
              placement="bottom"
              title="101 数据准备"
              width="150"
              trigger="click">
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">净值文件检查</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">估值文件检查</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">权重文件检查</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">停牌文件检查</el-button>
              <el-button slot="reference" size="mini" >101 数据准备</el-button>
            </el-popover>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-popover
              placement="bottom"
              title="201 参数检查"
              width="150"
              trigger="click">
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">数据检查</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">参数设置</el-button>
              <el-button slot="reference" size="mini" >201 参数检查</el-button>
            </el-popover>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-popover
              placement="bottom"
              title="301 PCF生成"
              width="150"
              trigger="click">
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">投资部生成PCF</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">运营部生成PCF</el-button>
              <el-button slot="reference" size="mini" >301 PCF生成</el-button>
            </el-popover>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-popover
              placement="bottom"
              title="401 准确性一致性核对"
              width="200"
              trigger="click">
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">O32与投资部PCF核对</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">投资部PCF与运营部PCF核对</el-button>
              <el-button size="mini" style="margin-left: unset;margin-top:5px;">投资部PCF与投资部DBF核对</el-button>
              <el-button slot="reference" size="mini" >401 准确性一致性核对</el-button>
            </el-popover>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-button size="mini">501 文件上传</el-button>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-button size="mini">601 返回文件核对</el-button>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-button size="mini">701 开盘前复查</el-button>
            <span class="el-icon-arrow-right" style="margin-left: 10px; margin-right: 10px;"></span>
            <el-button size="mini">801 开盘前确认</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'flow-demo',
  data () {
    return {
      tableData: [{
        fundCode: 515350,
        fundName: '民生加银300指数ETF基金',
        etfType: '上海跨市场',
        businessDate: '2022-03-23'
      }]
    }
  },
  methods: {
  }
}
</script>
<style scoped>
  .table-steps{
    background-color: #f5f7fa;
    padding: 5px;
  }
  .el-table >>> .el-table__cell{
    padding: 2px 0;
  }
</style>
