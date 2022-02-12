const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let arr;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr = input.split(' ').map(val => +val);
    rl.close();
  }
}).on('close', () => {
  console.log(solution());  
})

const solution = () => {
  const ans = Array.from({ length: n }, () => -1);
  const s = [];

  for(let i = 0; i < n; i++) {
    const next = arr[i];
    while(s.length > 0 && s[s.length - 1].value < next) {
      const { value, idx } = s.pop();
      ans[idx] = next;
    }
    s.push({ value: next, idx: i });
  }

  return ans.join(' ');
}