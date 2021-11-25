const solution = (answers) => {
  const students = [
    { sol: [1, 2, 3, 4, 5], ans: 0, repeat: 5, sno: 1 },
    { sol: [2, 1, 2, 3, 2, 4, 2, 5], ans: 0, repeat: 8, sno: 2 },
    { sol: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], ans: 0, repeat: 10, sno: 3 }
  ];

  students.forEach((student, idx) => {
    let ans = 0;
    for(let i = 0; i <= answers.length; i++) {
      if(student.sol[i % student.repeat] === answers[i]) {
        ans++;
      }
    }
    students[idx].ans = ans;
  })

  return students.sort((a, b) => b.ans - a.ans).reduce((pre, cur, idx) => {
    if(idx === 0 || cur.ans === pre[0].ans) {
      pre.push({ ans: cur.ans, sno: cur.sno });
    }
    return pre;
  }, []).map(item => item.sno);
}

const testcase = [
  { 'answers': [1,2,3,4,5] },
  { 'answers': [1,3,2,4,2] },
  { 'answers': [2] },
];

testcase.forEach(({ answers }) => {
  console.log(solution(answers));
})