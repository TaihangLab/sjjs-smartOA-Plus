import request from '@/utils/request'

// 查询大事记详细
export function getMilestone(milestoneId) {
    return request({
      url: 'project/list/0' ,
      method: 'get'
    })
  }
// 新增公告
export function addMilestone(data) {
    return request({
      url: 'project/my',
      method: 'post',
      data: data
    })
  }
// 修改大事记
export function editMilestone(data) {
    return request({
      url: 'project/my',
      method: 'put',
      data: data
    })
  }
  
// 删除大事记
export function deleteMilestone(milestoneId) {
return request({
    url: 'project/my' + milestoneId,
    method: 'delete'
})
}
  
