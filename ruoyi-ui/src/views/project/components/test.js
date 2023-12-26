

let projectMemberForm = {
    items : [{id: undefined, role:undefined}]
}


console.log(projectMemberForm.items)

const members = projectMemberForm.items.map(value => {
    return {userId: value.id, projectUserRole: value.role}
});

console.log(members)
