const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  if(n === 0) console.log(0);
  else {
    let cnt2 = 0;
    let cnt5 = 0;
    for(let i = 1; i <= n; i++) {
      let now = i;
      while(now % 2 === 0) {
        cnt2++;
        now /= 2;
      }
      while(now % 5 === 0) {
        cnt5++;
        now /= 5;
      }
    }
    console.log(Math.min(cnt2, cnt5));
  }
});