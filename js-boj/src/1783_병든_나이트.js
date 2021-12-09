const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const solution = (n, m) => {
  if(n === 1 || m === 1) return 1;
  if(n === 2) return m > 7 ? 4 : Math.ceil(m / 2);
  if(m < 7) return m > 4 ? 4 : m;
  return m - 2;
}

let n, m;
rl.on('line', (line) => {
  [n, m] = line.split(' ');
  rl.close();
}).on('close', () => {
  console.log(solution(Number(n), Number(m)));
})
