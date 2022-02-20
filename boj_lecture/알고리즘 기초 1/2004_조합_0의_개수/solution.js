const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let a;
let b;
rl.on('line', (input) => {
  [a, b] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  let cnt2 = getCount2(a) - getCount2(a - b) - getCount2(b);
  let cnt5 = getCount5(a) - getCount5(a - b) - getCount5(b);

  console.log(Math.min(cnt2, cnt5));
});

const getCount2 = (num) => {
  let count = 0;
  while(num >= 2) {
    const divided = Math.floor(num / 2);
    count += divided;
    num = divided;
  }
  return count;
}

const getCount5 = (num) => {
  let count = 0;
  while(num >= 5) {
    const divided = Math.floor(num / 5);
    count += divided;
    num = divided;
  }
  return count;
}