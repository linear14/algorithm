// function solution(participant, completion) {
//   completion.forEach((target) => {
//     const i = participant.findIndex(item => item === target);
//     participant.splice(i, 1);
//   })
//   return participant[0];
// }

function solution(participant, completion) {
  const map = new Map();
  participant.forEach(item => {
    if(map.has(item)) {
      map.set(item, map.get(item) + 1);
    } else { 
      map.set(item, 1);
    }
  });

  completion.forEach(item => {
    if(map.get(item) === 1) {
      map.delete(item);
    } else {
      map.set(item, map.get(item) - 1);
    }
  });

  return Array.from(map.keys())[0];
}

const testData = [
  { participant: ["leo", "kiki", "eden"], completion: ["eden", "kiki"] },
  { participant: ["marina", "josipa", "nikola", "vinko", "filipa"], completion: ["josipa", "filipa", "marina", "nikola"] },
  { participant: ["mislav", "stanko", "mislav", "ana"], completion: ["stanko", "ana", "mislav"] },
]

testData.forEach(({ participant, completion }) => {
  console.log(solution(participant, completion));
})