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
  const dp = Array.from({ length: n }, () => Array(2));
  let ans = 0;

  for(let i = 0; i < n; i++) {
    let ascMax = 0;
    let descMax = 0;
    for(let j = 0; j < i; j++) {
      if(arr[i] > arr[j]) {
        ascMax = Math.max(ascMax, dp[j][0]);
      }
      if(arr[i] < arr[j]) {
        descMax = Math.max(descMax, ...dp[j]);
      }
    }
    dp[i] = [ascMax + 1, descMax + 1];
    ans = Math.max(ans, ...dp[i]);
  }

  console.log(ans);
});