const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let arr;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  let ans = arr[0];
  for(let i = 1; i < n; i++) {
    arr[i] = Math.max(arr[i-1] + arr[i], arr[i]);
    ans = Math.max(ans, arr[i]);
  }
  console.log(ans);
});