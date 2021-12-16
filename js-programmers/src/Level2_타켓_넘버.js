const solution = (numbers, target) => {
  const sign = [-1, 1];
  let ans = 0;

  const bt = ({ sum, level }) => {
    if(level === numbers.length) {
      if(sum === target) ans++;
      return;
    }
  
    for(let i = 0; i < 2; i++) {
      bt({ sum: sum + numbers[level] * sign[i], level: level + 1});
    }
  }

  bt({ sum: 0, level: 0 });
  return ans;
}

const testcase = [
  { 'numbers': [1, 1, 1, 1, 1], 'target': 3 },
];

testcase.forEach(({ numbers, target }) => {
  console.log(solution(numbers, target));
})