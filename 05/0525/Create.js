export default {
  template: `
    <div>
      <h2 class="text-center">사원 정보 등록</h2>
      <table class="table table-condensed w-40">
        <tr>
          <th>이름</th>
          <td>
            <input
              type="text"
              v-model="name"
              ref="name"
              id="name"
              placeholder="이름을 입력해주세요"
            />
          </td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>
            <input type="text" v-model="mailid" id="mailid" placeholder="이메일을 입력해주세요" />
          </td>
        </tr>
        <tr>
          <th>고용일</th>
          <td>
            <input
              type="date"
              v-model="start_date"
              id="start_date"
              placeholder="고용일을 입력해주세요"
            />
          </td>
        </tr>
        <tr>
          <th>관리자</th>
          <td>
            <input
              type="text"
              v-model="manager_id"
              id="manager_id"
              placeholder="관리자를 입력해주세요"
            />
          </td>
        </tr>
        <tr>
          <th>직책</th>
          <td>
            <select v-model="title" id="title">
              <option value="" disabled selected>직책을 선택해주세요</option>
              <option value="사장">사장</option>
              <option value="기획부장">기획부장</option>
              <option value="총무부장">총무부장</option>
              <option value="인사부장">인사부장</option>
              <option value="과장">과장</option>
              <option value="영업대표이사">영업대표이사</option>
              <option value="사원" selected>사원</option>
              </select>
              </td>
              </tr>
              <tr>
              <th>부서</th>
              <td>
              <select v-model="dept_id" id="dept_id">
              <option value="" disabled selected>부서를 선택해주세요</option>
              <option value=118>인사부</option>
              <option value=101>총무부</option>
              <option value=110>기획부</option>
              <option value=102>영업부</option>
            </select>
            </td>
        </tr>
        <tr>
        <th>월급</th>
          <td>
          <input type="text" v-model="salary" id="salary" placeholder="월급을 입력해주세요" />
          </td>
        </tr>
        <tr>
        <th>커미션</th>
          <td>
          <select v-model="commission_pct" id="commission_pct" ref="commission_pct">
              <option value="" disabled selected>커미션을 선택해주세요</option>
              <option value="10" selected>10</option>
              <option value="12.5">12.5</option>
              <option value="15">15</option>
              <option value="17.5">17.5</option>
              <option value="20">20</option>
            </select>
          </td>
        </tr>
      </table>
      <div class="text-right">
        <button class="btn btn-primary" @click="createHandler">사원등록</button>
        <button class="btn btn-primary" @click="moveHandler">목록</button>
      </div>
    </div>
  `,
  data() {
    return {
      id: "",
      name: "",
      mailid: "",
      start_date: "",
      manager_id: "",
      title: "",
      dept_id: "",
      salary: "",
      commission_pct: ""
    };
  },
  methods: {
    moveHandler() {
      this.$router.push("/list");
    },
    createHandler() {
      // 데이타 검증
      let err = true;
      let msg = "";

      !this.name && ((msg = "이름을 입력해주세요"), (err = false), this.$refs.name.focus());
      err &&
        !this.commission_pct &&
        ((msg = "커미션을 선택해주세요"), (err = false), this.$refs.commission_pct.focus());
      if (!err) {
        alert(msg);
      } else {
        axios
          .post(`http://localhost:8197/api/addEmployee`, {
            name: this.name,
            mailid: this.mailid,
            start_date: this.start_date,
            manager_id: this.manager_id,
            title: this.title,
            dept_id: this.dept_id,
            salary: this.salary,
            commission_pct: this.commission_pct
          })
          .then(({ data }) => {
            if (data.state == "succ") {
              this.moveHandler();
              alert("등록 완료");
            } else {
              alert("등록 실패");
            }
          })
          .catch(err => {
            alert("등록 중 오류발생");
          });
      }
    }
  }
};
