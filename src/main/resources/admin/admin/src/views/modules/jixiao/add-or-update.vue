<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yuangong'">
                    <el-form-item class="select" v-if="type!='info'"  label="员工" prop="yuangongId">
                        <el-select v-model="ruleForm.yuangongId" :disabled="ro.yuangongId" filterable placeholder="请选择员工" @change="yuangongChange">
                            <el-option
                                    v-for="(item,index) in yuangongOptions"
                                    v-bind:key="item.id"
                                    :label="item.yuangongName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工编号" prop="yuangongUuidNumber">
                        <el-input v-model="yuangongForm.yuangongUuidNumber"
                                  placeholder="员工编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="员工编号" prop="yuangongUuidNumber">
                            <el-input v-model="ruleForm.yuangongUuidNumber"
                                      placeholder="员工编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工姓名" prop="yuangongName">
                        <el-input v-model="yuangongForm.yuangongName"
                                  placeholder="员工姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="员工姓名" prop="yuangongName">
                            <el-input v-model="ruleForm.yuangongName"
                                      placeholder="员工姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工手机号" prop="yuangongPhone">
                        <el-input v-model="yuangongForm.yuangongPhone"
                                  placeholder="员工手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="员工手机号" prop="yuangongPhone">
                            <el-input v-model="ruleForm.yuangongPhone"
                                      placeholder="员工手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工身份证号" prop="yuangongIdNumber">
                        <el-input v-model="yuangongForm.yuangongIdNumber"
                                  placeholder="员工身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="员工身份证号" prop="yuangongIdNumber">
                            <el-input v-model="ruleForm.yuangongIdNumber"
                                      placeholder="员工身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yuangong' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yuangongPhoto" label="员工头像" prop="yuangongPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yuangongForm.yuangongPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yuangongPhoto" label="员工头像" prop="yuangongPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yuangongPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="部门" prop="bumenValue">
                        <el-input v-model="yuangongForm.bumenValue"
                                  placeholder="部门" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="部门" prop="bumenValue">
                            <el-input v-model="ruleForm.bumenValue"
                                      placeholder="部门" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="职位" prop="zhiweiValue">
                        <el-input v-model="yuangongForm.zhiweiValue"
                                  placeholder="职位" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="职位" prop="zhiweiValue">
                            <el-input v-model="ruleForm.zhiweiValue"
                                      placeholder="职位" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工邮箱" prop="yuangongEmail">
                        <el-input v-model="yuangongForm.yuangongEmail"
                                  placeholder="员工邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="员工邮箱" prop="yuangongEmail">
                            <el-input v-model="ruleForm.yuangongEmail"
                                      placeholder="员工邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="账户状态" prop="jinyongValue">
                        <el-input v-model="yuangongForm.jinyongValue"
                                  placeholder="账户状态" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="账户状态" prop="jinyongValue">
                            <el-input v-model="ruleForm.jinyongValue"
                                      placeholder="账户状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yuangongId" name="yuangongId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="绩效编号" prop="jixiaoUuidNumber">
                       <el-input v-model="ruleForm.jixiaoUuidNumber"
                                 placeholder="绩效编号" clearable  :readonly="ro.jixiaoUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="绩效编号" prop="jixiaoUuidNumber">
                           <el-input v-model="ruleForm.jixiaoUuidNumber"
                                     placeholder="绩效编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="绩效标题" prop="jixiaoName">
                       <el-input v-model="ruleForm.jixiaoName"
                                 placeholder="绩效标题" clearable  :readonly="ro.jixiaoName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="绩效标题" prop="jixiaoName">
                           <el-input v-model="ruleForm.jixiaoName"
                                     placeholder="绩效标题" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jixiaoFile" label="附件" prop="jixiaoFile">
                        <file-upload
                                tip="点击上传附件"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.jixiaoFile?$base.url+ruleForm.jixiaoFile:''"
                                @change="jixiaoFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.jixiaoFile" label="附件" prop="jixiaoFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="$base.url+ruleForm.jixiaoFile"  >附件下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="绩效类型" prop="jixiaoTypes">
                        <el-select v-model="ruleForm.jixiaoTypes" :disabled="ro.jixiaoTypes" placeholder="请选择绩效类型">
                            <el-option
                                v-for="(item,index) in jixiaoTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="绩效类型" prop="jixiaoValue">
                        <el-input v-model="ruleForm.jixiaoValue"
                            placeholder="绩效类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="绩效打分" prop="jixiaoDafen">
                       <el-input v-model="ruleForm.jixiaoDafen"
                                 placeholder="绩效打分" clearable  :readonly="ro.jixiaoDafen"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="绩效打分" prop="jixiaoDafen">
                           <el-input v-model="ruleForm.jixiaoDafen"
                                     placeholder="绩效打分" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info' && !ro.pingguTime"  class="input" label="评估时间" prop="pingguTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.pingguTime"
                                type="datetime"
                                placeholder="评估时间"
                                :disabled="ro.pingguTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pingguTime" label="评估时间" prop="pingguTime">
                            <span v-html="ruleForm.pingguTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

                <el-col :span="24">
                    <el-form-item v-if="type!='info' && !ro.jixiaoContent"  label="打分缘由" prop="jixiaoContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.jixiaoContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jixiaoContent" label="打分缘由" prop="jixiaoContent">
                            <span v-html="ruleForm.jixiaoContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yuangongForm: {},
                ro:{
                    yuangongId: false,
                    jixiaoUuidNumber: true,
                    jixiaoName: false,
                    jixiaoFile: false,
                    jixiaoTypes: false,
                    jixiaoDafen: false,
                    pingguTime: false,
                    jixiaoContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    yuangongId: '',
                    jixiaoUuidNumber: new Date().getTime(),
                    jixiaoName: '',
                    jixiaoFile: '',
                    jixiaoTypes: '',
                    jixiaoDafen: '',
                    pingguTime: '',
                    jixiaoContent: '',
                    insertTime: '',
                },
                jixiaoTypesOptions : [],
                yuangongOptions : [],
                rules: {
                   yuangongId: [
                              { required: true, message: '员工不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jixiaoUuidNumber: [
                              { required: true, message: '绩效编号不能为空', trigger: 'blur' },
                          ],
                   jixiaoName: [
                              { required: true, message: '绩效标题不能为空', trigger: 'blur' },
                          ],
                   jixiaoFile: [
                              { required: true, message: '附件不能为空', trigger: 'blur' },
                          ],
                   jixiaoTypes: [
                              { required: true, message: '绩效类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jixiaoDafen: [
                              { required: true, message: '绩效打分不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   pingguTime: [
                              { required: true, message: '评估时间不能为空', trigger: 'blur' },
                          ],
                   jixiaoContent: [
                              { required: true, message: '打分缘由不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '记录时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录员工的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }else{
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jixiao_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jixiaoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `yuangong/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yuangongOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取员工信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yuangongChange(id){
                this.$http({
                    url: `yuangong/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yuangongForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `jixiao/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yuangongChange(data.data.yuangongId)
                        _this.ruleForm.jixiaoContent = _this.ruleForm.jixiaoContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.jixiaoContent = this.ruleForm.jixiaoContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`jixiao/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.jixiaoCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.jixiaoCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            jixiaoFileUploadChange(fileUrls){
                this.ruleForm.jixiaoFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
    height: 500px;

& /deep/ .ql-container {
      height: 310px;
  }
}
.amap-wrapper {
    width: 100%;
    height: 500px;
}
.search-box {
    position: absolute;
}
.addEdit-block {
    margin: -10px;
}
.detail-form-content {
    padding: 12px;
    background-color: transparent;
}
.btn .el-button {
    padding: 0;
}</style>

