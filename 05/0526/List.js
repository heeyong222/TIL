export default {
  template: `
    <div>
			<h2 class="text-center">사원목록</h2>
			<div v-if="emps.length>0">
				<div class="text-center">
					<input type="text" v-model="word" />
					<button class="btn btn-secondary" @click="searchEmp">검색</button>
				</div>
				<br />
				<table class="table table-boardered table-condensed">
					<colgroup>
						<col width="20%" />
						<col width="20%" />
						<col width="20%" />
						<col width="20%" />
						<col width="20%" />
					</colgroup>
					<tr>
						<th>사원 아이디</th>
						<th>사원명</th>
						<th>부서</th>
						<th>직책</th>
						<th>연봉</th>
					</tr>
					<tr v-for="emp in emps">
						<td>{{emp.id}}</td>
						<td><router-link :to="'/search?id='+emp.id">{{emp.name}}</router-link></td>
						<td v-text="emp.dept_id"></td>
						<td v-text="emp.title"></td>
						<td v-text="emp.salary"></td>
					</tr>
				</table>
			</div>
			<div v-else>등록된 사원 정보가 없습니다.</div>
			<div class="text-right">
				<button class="btn btn-primary" @click="movePage">등록</button>
			</div>
		</div>
  `,
  data() {
    return {
      word: "",
      emps: [],
    };
  },
  methods: {
    movePage() {
      this.$router.push("/create");
    },
    searchEmpAll() {
      axios
        .get(`http://localhost:8197/api/findAllEmployees`)
        .then(({ data }) => {
          this.emps = data;
          console.log("list......", data);
        })
        .catch((err) => {
          alert("오류 발생");
        });
    },
    searchEmp() {
      if (this.word) {
        axios
          .get(`http://localhost:8197/api/findLikeEmployees/${this.word}`)
          .then(({ data }) => {
            this.emps = data;
          })
          .catch((err) => {
            alert("오류 발생");
          });
      }
    },
  },
  created() {
    this.searchEmpAll();
  },
};
