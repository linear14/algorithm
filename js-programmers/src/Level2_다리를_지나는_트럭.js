const solution = (bridge_length, weight, truck_weights) => {

  let time = 0;
  let nextIdx = 0;
  let bridge = []; // startTime, weight
  let bridgeWeight = 0;

  while(++time) {
    // 일단 먼저 도착한 트럭 내려주기
    if(bridge.length !== 0) {
      if(time - bridge[0].startTime === bridge_length) {
        const out = bridge.shift();
        bridgeWeight -= out.weight; 
      }
    }

    // 다음 대기 트럭이 들어갈 수 있는지 확인
    const next = truck_weights[nextIdx];
    if(next + bridgeWeight <= weight) {
      if (bridge.length < bridge_length) {
        bridge.push({ startTime: time, weight: next });
        bridgeWeight += next;
        nextIdx++;
      }
    } 

    // 또 다른 대기 트럭이 있는지 확인
    // 없다면 방금 들어간 트럭이 도착하는 시간 반환
    if(nextIdx >= truck_weights.length) {
      return time + bridge_length;
    }
  }
};

const testData = [
  { bridge_length	: 2, weight: 10, truck_weights: [7,4,5,6] },
  { bridge_length	: 100, weight: 100, truck_weights: [10] },
  { bridge_length	: 100, weight: 100, truck_weights: [10,10,10,10,10,10,10,10,10,10] },
];

testData.forEach(({ bridge_length, weight, truck_weights }) => {
  console.log(solution(bridge_length, weight, truck_weights));
});
