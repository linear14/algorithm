const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
let next = 1;
const arr = [];

rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(+input);
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  console.log(solution());
})

const solution = () => {
  const ans = [];
  const s = [];

  for(let i = 0; i < n; i++) {
    const target = arr[i];
    while(target >= next) {
      s.push(next++);
      ans.push('+');
    }
    const popped = s.pop();
    if(target === popped) {
      ans.push('-');
    }
    else {
      return 'NO';
    }
  }
  return ans.join('\n');
}