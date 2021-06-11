export default {
  template: `
  <div>
			<h2 class="text-center">사원정보</h2>
			<table class="table table-condensed w-40" v-if="emp">
				<tr>
					<th>아이디</th>
					<td v-text="emp.id"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td v-text="emp.name"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td v-text="emp.mailid"></td>
				</tr>
				<tr>
					<th>고용일</th>
					<td v-text="emp.start_date"></td>
				</tr>
				<tr>
					<th>관리자</th>
					<td v-text="emp.manager_id"></td>
				</tr>
				<tr>
					<th>직책</th>
					<td v-text="emp.title"></td>
				</tr>
				<tr>
					<th>부서</th>
					<td v-text="emp.dept_id"></td>
				</tr>
				<tr>
					<th>월급</th>
					<td v-text="emp.salary"></td>
				</tr>
				<tr>
					<th>커미션</th>
					<td v-text="emp.commission_pct"></td>
				</tr>
			</table>
			<div class="text-right">
				<router-link class="btn btn-primary" to="/list">목록</router-link>
			
			</div>
		</div>
  `,
  data() {
    return {
      emp: {}
    };
  },
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:8197/api/findEmployeeById/${params.get("id")}`)
      .then(({ data }) => {
        this.emp = data;
      })
      .catch(err => {
        alert("조회 중 오류 발생");
      });
  }
};
