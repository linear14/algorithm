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
  const count = {};

  for(let i = 0; i < n; i++) {
    count[arr[i]] = count[arr[i]] ? count[arr[i]] + 1 : 1;
  }

  arr = arr.map((item, idx) => ({ value: item, index: idx, count: count[item]}));
  
  for(let i = 0; i < n; i++) {
    const next = arr[i];

    while(s.length > 0 && s[s.length - 1].count < next.count) {
      const popped = s.pop();
      ans[popped.index] = next.value;
    }

    s.push({ value: next.value, index: next.index, count: next.count });
  }

  return ans.join(' ');
}