const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const arr = []
rl.on('line', (input) => {
  arr.push(+input);
  if(arr.length === 9) rl.close();
}).on('close', () => {
  const sum = arr.reduce((pre, cur) => pre + cur, 0);
  for(let i = 0; i < 9; i++) {
    for(let j = i + 1; j < 9; j++) {
      const isHundred = sum - (arr[i] + arr[j]) === 100;
      if(isHundred) {
        const ansArr = arr.filter((_, idx) => idx !== i && idx !== j);
        console.log(ansArr.sort((a, b) => +a - +b).join('\n'));
        return;
      }
    }
  }
});