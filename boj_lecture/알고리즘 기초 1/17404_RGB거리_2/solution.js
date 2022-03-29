const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  const min_r = getMinPrice(0);
  const min_g = getMinPrice(1);
  const min_b = getMinPrice(2);

  console.log(Math.min(min_r, min_g, min_b));  
});

const getMinPrice = (idx) => {
  const MAX = 2000000;
  const [ix, iy, iz] = [idx, (idx + 1) % 3, (idx + 2) % 3];
  const dp = Array.from({ length: n }, () => [MAX, MAX, MAX]);
  dp[0][idx] = arr[0][idx];
  
  for(let i = 1; i < n; i++) {
    if(i !== 1 && i !== n-1) {
      dp[i][ix] = arr[i][ix] + Math.min(dp[i-1][iy], dp[i-1][iz]);
    }
    dp[i][iy] = arr[i][iy] + Math.min(dp[i-1][ix], dp[i-1][iz]);
    dp[i][iz] = arr[i][iz] + Math.min(dp[i-1][ix], dp[i-1][iy]);
  }

  return Math.min(...dp[n-1]);
}