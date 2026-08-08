package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import com.tydino.everbloomdandaloo.Utilities.MathUtility;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;

public class BrachiosaurusJuvenileModel extends EntityModel<BrachiosaurusRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("everbloomdandaloo", "brachiosaurus"), "main");

	private final ModelPart root;
	private final ModelPart butt;
	private final ModelPart chest;
	private final ModelPart neckbase;
	private final ModelPart nackmiddle;
	private final ModelPart necktip;
	private final ModelPart headlead;
	private final ModelPart head;
	private final ModelPart bottomjaw;
	private final ModelPart eyes;
	private final ModelPart tailbase;
	private final ModelPart tailmiddle;
	private final ModelPart tailmiddletip;
	private final ModelPart tailtip;
	private final ModelPart frontleftfoot;
	private final ModelPart frontleftshin;
	private final ModelPart frontleftknee;
	private final ModelPart frontleftthigh;
	private final ModelPart frontrightfoot;
	private final ModelPart frontrightshin;
	private final ModelPart frontrightknee;
	private final ModelPart frontrightthigh;
	private final ModelPart backleftfoot;
	private final ModelPart backleftshin;
	private final ModelPart backleftthigh;
	private final ModelPart backrightfoot;
	private final ModelPart backrightshin;
	private final ModelPart backrightthigh;

	final KeyframeAnimation idle;
	final KeyframeAnimation eat;
	final KeyframeAnimation walk;
	final KeyframeAnimation sitDown;
	final KeyframeAnimation sitting;
	final KeyframeAnimation standUp;
	final KeyframeAnimation blinking;

	final KeyframeAnimation leanOver;

	public BrachiosaurusJuvenileModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.butt = this.root.getChild("butt");
		this.chest = this.butt.getChild("chest");
		this.neckbase = this.chest.getChild("neckbase");
		this.nackmiddle = this.neckbase.getChild("nackmiddle");
		this.necktip = this.nackmiddle.getChild("necktip");
		this.headlead = this.necktip.getChild("headlead");
		this.head = this.headlead.getChild("head");
		this.bottomjaw = this.head.getChild("bottomjaw");
		this.eyes = this.head.getChild("eyes");
		this.tailbase = this.butt.getChild("tailbase");
		this.tailmiddle = this.tailbase.getChild("tailmiddle");
		this.tailmiddletip = this.tailmiddle.getChild("tailmiddletip");
		this.tailtip = this.tailmiddletip.getChild("tailtip");
		this.frontleftfoot = this.root.getChild("frontleftfoot");
		this.frontleftshin = this.frontleftfoot.getChild("frontleftshin");
		this.frontleftknee = this.frontleftshin.getChild("frontleftknee");
		this.frontleftthigh = this.frontleftknee.getChild("frontleftthigh");
		this.frontrightfoot = this.root.getChild("frontrightfoot");
		this.frontrightshin = this.frontrightfoot.getChild("frontrightshin");
		this.frontrightknee = this.frontrightshin.getChild("frontrightknee");
		this.frontrightthigh = this.frontrightknee.getChild("frontrightthigh");
		this.backleftfoot = this.root.getChild("backleftfoot");
		this.backleftshin = this.backleftfoot.getChild("backleftshin");
		this.backleftthigh = this.backleftshin.getChild("backleftthigh");
		this.backrightfoot = this.root.getChild("backrightfoot");
		this.backrightshin = this.backrightfoot.getChild("backrightshin");
		this.backrightthigh = this.backrightshin.getChild("backrightthigh");

		this.idle = BrachiosaurusJuvenileAnimations.idle.bake(root);
		this.eat = BrachiosaurusJuvenileAnimations.eating.bake(root);
		this.walk = BrachiosaurusJuvenileAnimations.walking.bake(root);
		this.sitDown = BrachiosaurusJuvenileAnimations.sittingdown.bake(root);
		this.sitting = BrachiosaurusJuvenileAnimations.sitting.bake(root);
		this.standUp = BrachiosaurusJuvenileAnimations.standingup.bake(root);
		this.blinking = BrachiosaurusJuvenileAnimations.blinking.bake(root);

		this.leanOver = BrachiosaurusJuvenileAnimations.leandown.bake(root);
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition butt = root.addOrReplaceChild("butt", CubeListBuilder.create(), PartPose.offset(0.0F, -32.0F, 24.0F));

		PartDefinition cube_r1 = butt.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -24.0F, -24.0F, 24.0F, 24.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 8.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, -16.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r2 = chest.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 56).addBox(-15.0F, -28.0F, -24.0F, 30.0F, 32.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition neckbase = chest.addOrReplaceChild("neckbase", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -18.0F));

		PartDefinition cube_r3 = neckbase.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 112).addBox(-10.0F, -12.0F, -14.0F, 20.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition nackmiddle = neckbase.addOrReplaceChild("nackmiddle", CubeListBuilder.create().texOffs(112, 0).addBox(-5.0F, -40.0F, -8.0F, 10.0F, 48.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -10.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition necktip = nackmiddle.addOrReplaceChild("necktip", CubeListBuilder.create().texOffs(156, 39).addBox(-2.5F, -39.5F, -3.0F, 5.0F, 42.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition headlead = necktip.addOrReplaceChild("headlead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -37.0F, -2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = headlead.addOrReplaceChild("head", CubeListBuilder.create().texOffs(100, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top_jaw_r1 = head.addOrReplaceChild("top_jaw_r1", CubeListBuilder.create().texOffs(80, 7).addBox(-2.5F, -3.0F, -0.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -9.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(80, 0).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -5.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bottomjaw = head.addOrReplaceChild("bottomjaw", CubeListBuilder.create().texOffs(96, 12).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(90, -2).addBox(3.05F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(94, -2).addBox(-3.05F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition tailbase = butt.addOrReplaceChild("tailbase", CubeListBuilder.create().texOffs(120, 88).addBox(-8.0F, -8.0F, -0.5F, 16.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 8.0F));

		PartDefinition tailmiddle = tailbase.addOrReplaceChild("tailmiddle", CubeListBuilder.create().texOffs(0, 157).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition tail_middle_fin_r1 = tailmiddle.addOrReplaceChild("tail_middle_fin_r1", CubeListBuilder.create().texOffs(112, 64).addBox(-2.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tailmiddletip = tailmiddle.addOrReplaceChild("tailmiddletip", CubeListBuilder.create().texOffs(84, 88).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 19.0F));

		PartDefinition tailtip = tailmiddletip.addOrReplaceChild("tailtip", CubeListBuilder.create().texOffs(88, 60).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 22.5F));

		PartDefinition frontleftfoot = root.addOrReplaceChild("frontleftfoot", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -8.0F, -3.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, -4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frontleftshin = frontleftfoot.addOrReplaceChild("frontleftshin", CubeListBuilder.create().texOffs(0, 156).addBox(-2.5F, -17.0F, -2.0F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition frontleftknee = frontleftshin.addOrReplaceChild("frontleftknee", CubeListBuilder.create().texOffs(155, 158).addBox(-3.0F, -20.0F, -1.0F, 6.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition frontleftthigh = frontleftknee.addOrReplaceChild("frontleftthigh", CubeListBuilder.create().texOffs(96, 118).addBox(0.0F, -17.0F, -1.0F, 2.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 4.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition frontrightfoot = root.addOrReplaceChild("frontrightfoot", CubeListBuilder.create().texOffs(84, 56).addBox(-36.0F, -8.0F, -3.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, 0.0F, -4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frontrightshin = frontrightfoot.addOrReplaceChild("frontrightshin", CubeListBuilder.create().texOffs(40, 156).addBox(-37.5F, -17.0F, -2.0F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition frontrightknee = frontrightshin.addOrReplaceChild("frontrightknee", CubeListBuilder.create().texOffs(136, 132).addBox(-39.0F, -20.0F, -1.0F, 6.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition frontrightthigh = frontrightknee.addOrReplaceChild("frontrightthigh", CubeListBuilder.create().texOffs(116, 118).addBox(-38.0F, -17.0F, -1.0F, 2.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 4.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition backleftfoot = root.addOrReplaceChild("backleftfoot", CubeListBuilder.create(), PartPose.offset(11.0F, 0.0F, 28.0F));

		PartDefinition cube_r4 = backleftfoot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 172).addBox(-3.0F, -8.0F, -1.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition backleftshin = backleftfoot.addOrReplaceChild("backleftshin", CubeListBuilder.create().texOffs(56, 152).addBox(-3.5F, -14.0F, -4.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition backleftthigh = backleftshin.addOrReplaceChild("backleftthigh", CubeListBuilder.create().texOffs(80, 151).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 26.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition backrightfoot = root.addOrReplaceChild("backrightfoot", CubeListBuilder.create(), PartPose.offset(-10.0F, 0.0F, 28.0F));

		PartDefinition cube_r5 = backrightfoot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 115).addBox(-3.0F, -8.0F, -1.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition backrightshin = backrightfoot.addOrReplaceChild("backrightshin", CubeListBuilder.create().texOffs(72, 122).addBox(-3.5F, -14.0F, -4.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition backrightthigh = backrightshin.addOrReplaceChild("backrightthigh", CubeListBuilder.create().texOffs(112, 151).addBox(-5.0F, -24.0F, -4.0F, 8.0F, 26.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
		return LayerDefinition.create(modelData, 181, 185);
	}

	float lastBodyRot;
	float tailBaseDragRot;
	float tailMiddleDragRot;
	float tailTipDragRot;

	@Override
	public void setupAnim(BrachiosaurusRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimationState.isStarted()){
			this.blinking.apply(state.blinkAnimationState, state.ageInTicks);
		}

		if(state.idleAnimationState.isStarted()){
			this.idle.apply(state.idleAnimationState, state.ageInTicks);
		}

		if(state.eatAnimationState.isStarted()){
			this.eat.apply(state.eatAnimationState, state.ageInTicks);
			this.leanOver.apply(state.leanDownAnimationState, state.ageInTicks);
		}

		if(state.sittingdownAnimationState.isStarted()){
			this.sitDown.apply(state.sittingdownAnimationState, state.ageInTicks);
		}
		if(state.sitAnimationState.isStarted()){
			this.sitting.apply(state.sitAnimationState, state.ageInTicks);
		}
		if(state.standingupAnimationState.isStarted()){
			this.standUp.apply(state.standingupAnimationState, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 6f, 18f);

		//head
		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);

		//Tail
		float deltaYaw = MathUtility.wrapDegrees(state.bodyRot - this.lastBodyRot);
		float targetDragBase = -deltaYaw * 0.4F;
		this.tailBaseDragRot = Math.clamp(MathUtility.lerp(0.25F, this.tailBaseDragRot, targetDragBase), -1f, 1f);

		float targetDragMiddle = targetDragBase + -deltaYaw * 0.3F;
		this.tailMiddleDragRot = Math.clamp(MathUtility.lerp(0.3F, this.tailMiddleDragRot, -targetDragMiddle), -1f, 1f);

		float targetDragTip = targetDragMiddle + -deltaYaw * 0.2F;
		this.tailTipDragRot = Math.clamp(MathUtility.lerp(0.4F, this.tailTipDragRot, targetDragTip), -1f, 1f);

		this.tailmiddle.yRot = this.tailBaseDragRot;
		this.tailmiddletip.yRot =-this.tailMiddleDragRot;
		this.tailtip.yRot = this.tailTipDragRot;

		this.lastBodyRot = state.bodyRot;
	}
}