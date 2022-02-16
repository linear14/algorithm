const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let a, b;
rl.on('line', (input) => {
  [a, b] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  const gcd = getGreatestCommonDivisor(a, b);
  const lcm = getLeastCommonMultiple(gcd, a, b);
  
  console.log(`${gcd}\n${lcm}`);
})

// 최대공약수
const getGreatestCommonDivisor = (a, b) => {
  while(b !== 0) {
    const temp = a;
    a = b;
    b = temp % b;
  }
  return a;
}

// 최소공배수
const getLeastCommonMultiple = (gcd, a, b) => {
  return (a * b) / gcd;
}
