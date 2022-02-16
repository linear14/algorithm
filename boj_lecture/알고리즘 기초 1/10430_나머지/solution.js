const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let arr;
rl.on('line', (input) => {
  arr = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  const [a, b, c] = [arr[0], arr[1], arr[2]];
  console.log((a + b) % c);
  console.log(((a % c) + (b % c)) % c);
  console.log((a * b) % c);
  console.log(((a % c) * (b % c)) % c);
})